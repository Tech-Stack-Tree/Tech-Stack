var address = 'Seoul';
var members = {};
var addFamily = function(age, name, role){
    this.members[role] = {age, name};
};
var getHeadCount = function(){
    return Object.keys(this.members).length;
};

var family = {address, members, addFamily, getHeadCount};

family.addFamily(30, 'chleo', 'aunt');
family.addFamily(3, 'lyn', 'niece');
family.addFamily(10, 'dangdangi', 'dog');
console.log(family.getHeadCount()); //3
