var http = require('http');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();

var restController = require('./restController');

app.use(bodyParser.json({ limit: '10mb' }));
app.use(bodyParser.urlencoded({ extended: false }));

app.set('port', process.env.PORT || 3000);

app.use('/', restController);

app.use(function(req, res, next) {
    res.status(404).send('Not Found...' + '(' + req.originalUrl + ')');
});

app.use(function(err, req, res) {
    res.status(err.status || 500);
    res.send('Error occured...' + '(' + req.originalUrl + ')');
});

app.listen(app.get('port'));
