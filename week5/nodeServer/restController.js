var express = require('express');
var mysql = require('./lib/mysqlSupporter');
// var fileManager = require('./lib/fileManager');
var cryptoManager = require('./lib/cryptoManager');

var router = express.Router();

router.get('/', function(req, res) {
    console.log('test');
    res.end('test');
});

router.post('/user', function(req, res){
    var id = req.body.id;
    var password = req.body.password;

    var user = {id: id, password: password};

    var insertUser = function(user) {
    console.log('insert start');
        mysql.insertUser(user, function(err, result){
            if(err) {
        console.log('err!!!!');
                console.log(err);
        res.json({rspMsg: 'FAIL'});
        }
        res.json({rspMsg: 'SUCESS', data: result});
        });
    }
    insertUser(user);
});

router.get('/user/:userId', function(req, res){
    var userId = req.params.userId;

    mysql.getUser(userId, function(err, result){
    if(err) {
                console.log(err);
                res.json({rspMsg: 'FAIL'});
        }
        res.json({rspMsg: 'SUCESS', data: result});
    });

});

router.post('/user/login', function(req, res) {
  var userId = req.body.userId;
  var password = req.body.password;

  if (userId == null || password == null) {
    return res.json({rspCode : '500', rspMsg: 'Parameter mismatch'});
  }

  var checkUserExist = function(result) {
    if(result.length == 0) {
      res.json({rspCode: '401', rspMsg: '가입되지 않은 유저입니다.'});
    } else {
      checkPasswordCorrect(result);
    }
  }

  var checkPasswordCorrect = function(result) {
    if(result[0].password == password) {

      var session = cryptoManager.makeLoginSession(userId, password);
      mysql.insertSession(session, {_id : result[0]._id}, function(err, result2) {
          if(err) {
              res.json({rspCode: '500', rspMsg: 'FAIL : ' + err});
          } else {
            res.json({rspCode: '200', rspMsg: '로그인 성공', data: session});
          }
      });

    }else {
      res.json({rspCode: '401', rspMsg: '비밀번호를 확인하세요.'});
    }
  }

  mysql.getUser(userId, function(err, result){
    if(err) {
      res.json({rspCode: '500', rspMsg: 'FAIL : ' + err});
    } else {
      checkUserExist(result);
    }
  });
});

// router.post('/image/upload', function(req, res) {
//   fileManager.uploadImage(req, res);
// });

module.exports = router;
