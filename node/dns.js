const dns = require('dns')

let domain = 'ku66.cc'

dns.lookup(domain, function(err, address){
  if(err){
    console.info(err)
    return
  }
  console.info(address)
})