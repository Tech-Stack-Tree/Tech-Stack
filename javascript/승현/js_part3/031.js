var obj = {};
for (var i = 0; i < 4; i++) {
  obj["key" + i] = i;
}

console.log(obj);

var profile = "chlole:30";
var person = {
  [profile]: true,
  [profile.split(":")[0]]: profile.split(":")[1],
};

console.log(person);
