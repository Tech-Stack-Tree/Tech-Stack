var obj = {};
for(var i=0; i<4; i++){
    obj['key'+i] = i;
}
console.log(obj);   //{ key0: 0, key1: 1, key2: 2, key3: 3 }

var profile = 'chloe:30';
var person = {
    [profile] : true,
    [profile.split(':')[0]]: profile.split(':')[1]
};
console.log(person); //{ 'chloe:30': true, chloe: '30' }