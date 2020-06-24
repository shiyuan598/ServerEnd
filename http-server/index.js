var http = require('http')
var fs = require('fs')
var url = require('url')
var path = require('path')

var mime = require('./mime.js')

var server = http.createServer(function (request, response){
  var filePath = './static' + url.parse(request.url).pathname
  console.info(filePath)
  if(filePath === './static/'){
    filePath = './static/index.html'
  }
  fs.exists(filePath, function(exist){
    filePath = !exist ? './static/error-page/404.html' : filePath
    var data = fs.readFileSync(filePath)
    var contentType = mime[path.extname(filePath)]
    response.writeHead(200, {
      'Content-Type': contentType
    })
    response.write(data)
    response.end()
  })

}).listen(1337, '127.0.0.1', function() {
  console.info('sever: 127.0.0.1:1337...')
})