var crypto = require('crypto');
var moment = require('moment');

exports.makeLoginSession = function(id, pw) {
  var secret = moment();
  var hash = crypto.createHash('sha256')
                   .update(id + pw + secret)
                   .digest('hex');
  console.log(hash);
  return hash;
}
