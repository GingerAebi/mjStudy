
var moment = require('moment');
var path = require('path');
var Busboy = require('busboy');
var fs = require('fs');

exports.uploadImage = function(req, res, next) {
  var busboy = new Busboy({ headers: req.headers });

   // Listen for event when Busboy finds a file to stream.
    busboy.on('file', function(fieldname, file, filename, encoding, mimetype) {
        console.log("In bus boy");
        // We are streaming! Handle chunks
        var saveTo = path.join('./upload/', filename);
        console.log('Uploading: ' + saveTo);
        file.pipe(fs.createWriteStream(saveTo));
        file.on('data', function(data) {
            // Here we can act on the data chunks streamed.
            console.log("Chunk mila");
        });

        // Completed streaming the file.
        file.on('end', function() {
            console.log('Finished with ' + fieldname);
        });
    });
    busboy.on('field', function(fieldname, val, fieldnameTruncated, valTruncated, encoding, mimetype) {
        console.log('Field [' + fieldname + ']: value: ' + inspect(val));
    });

    busboy.on('finish', function() {
        console.log("out of busboy");
        res.sendStatus(200);
    });
    req.pipe(busboy);
}
