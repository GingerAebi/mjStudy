var mysql = require('mysql');

var pool  = mysql.createPool({
  host: "localhost",
  user: "root",
  password: "study123",
  database: 'pinterest',
  connectionLimit: 60,
  waitForConnection: true
});

exports.insertUser = function(user, next){
    pool.getConnection(function (err, connection) {
        if (err) {
            console.log('err:' + err);
            next(new Error('ERR.MYSQL.CONN'));
            return;
        }
        connection.query('INSERT INTO User(userId, password) VALUES(?, ?)', [user.id, user.password], function (err, result) {

            connection.release();
            if (err) {
                next(err);
            }
            else {
                next(null, result);
            }
        });
    });
};

exports.getUser = function(userId, next){
    pool.getConnection(function(err, connection) {
        if(err) {
        console.log('err : ' + err);
        next(err);
    }
    connection.query('SELECT * FROM User WHERE userId = ?', userId, function(err, result) {
        if (err) {
                next(err);
            }
            else {
                next(null, result);
            }
    });
    });
};
