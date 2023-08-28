const fruits = ['melon', 'lemon', 'source', 'apple', 'juice'];

fruits.splice(4, 1);
fruits.splice(4, 0, 'grape');
fruits.splice(2, 0, 'mandarin', 'strawberry', 'watermelon');

console.log(fruits);

/*
[
  'melon',
  'lemon',
  'mandarin',
  'strawberry',
  'watermelon',
  'source',
  'apple',
  'grape'
]
*/