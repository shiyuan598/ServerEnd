let xlsx = require('node-xlsx')
let fs = require('fs')
let data = [
  {
    name: 'sheet1',
    data: [
      [
        'Id',
        'Name',
        'Age'
      ],
      [
        '1',
        'shiyuan',
        29
      ],
      [
        '2',
        'toto',
        28
      ]
    ]
  },
  {
    name: 'sheet2',
    data: [
      [
        'Name',
        'Hobby'
      ],
      [
        'tug',
        'sleep'
      ],
      [
        'pig',
        'cooking'
      ]
    ]
  }
]

let buffer = xlsx.build(data)
fs.writeFile('./write.xls', buffer, function(err) {
  if (err) {
    console.info(err)
  } else {
    console.log('write success!')
    //读出来
    var obj = xlsx.parse('./write.xls')
    console.info(JSON.stringify(obj))
  }
})