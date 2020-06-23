const request = require('request')
const path = require('path')
const fs = require('fs')
const config = require('./config')
const analyze = require('./analyze')

function start(){
  request(config.url, function(err, res, body){
    console.info('start')
    if(!err && res){
      console.info('start')
      analyze.findImg(body, downLoad)
    }
  })
}

function downLoad(imgUrl, i){
  let ext = imgUrl.split('.').pop()
  request(imgUrl).pipe(fs.createWriteStream(path.join(config.imgDir, i + '.' + ext), {
    'encoding': 'utf8'
  }))
  console.info(i)
}

start()