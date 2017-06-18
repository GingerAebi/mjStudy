var express = require('express');
var mysql = require('./lib/mysqlSupporter');
var router = express.Router();

router.get('/', function(req, res) {
    console.log('test');
    res.end('test');
});

router.post('/user', function(req, res){
    var id = req.body.id;
    var password = req.body.password;

    var user = {id: id, password: password};

    console.log(user);

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

module.exports = router;
