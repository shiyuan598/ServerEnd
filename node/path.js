const path = require('path')
console.info(__dirname, __filename)

let outputPath = path.join(__dirname, 'none', 'file.js')
console.log(outputPath);

console.info(path.basename(outputPath))
console.info(path.dirname(outputPath))
console.info(path.extname(outputPath))
console.info(path.parse(outputPath))

