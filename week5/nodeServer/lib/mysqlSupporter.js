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

exports.insertSession = function(session, user, next) {
  pool.getConnection(function(err, connection) {
    var insert = function () {
      connection.query('INSERT INTO Session(_user_id, session, xAuth) VALUES(?,?,?)', [user._id, session, ''], function(err, result) {
          if (err) {
                  next(err);
              }
              else {
                  next(null, result);
              }
            });
    }

    var update = function () {
      connection.query('UPDATE Session SET session=?, xAuth=? WHERE _user_id = ?', [session, '',user._id], function(err, result) {
          if (err) {
                  next(err);
              }
              else {
                  next(null, result);
              }
            });
    }

    if(err) {
      console.log('err : ' + err);
      next(err);
    } else {
      connection.query('SELECT * FROM Session WHERE _user_id = ?', user._id, function (err, result) {
        if(err) {
          next(err);
        } else {
          if(result.length > 0) {
            update();
          } else {
            insert();
          }
        }
      });
    }
  });
}






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
