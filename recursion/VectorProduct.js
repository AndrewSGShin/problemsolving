function vectorProduct(lists, level, tuple, result) {
    lists[level].forEach(function(i) {
        if (level === lists.length - 1) {
          result.push(tuple + i)
        } else {
          vectorProduct(lists, level + 1, tuple + i + ' ', result)
        }
    })
}


var lists = [[1, 2, 3], [4, 5], [6, 7]]
var result = []

vectorProduct(lists, 0, '', result)

console.log(result)