function Storage() {
  this.dataStore = {};
}

Storage.prototype.put = function (key, data) {
  this.dataStore[key] = data;
};

Storage.prototype.getData = function (key) {
  return this.dataStore[key];
};

const productStorage = new Storage();
productStorage.put("id0001", { name: "키보드", price: 2000 });
console.log(productStorage.getData("id0001"));

function RemovableStorage() {
  Storage.call(this);
}

RemovableStorage.prototype = Object.create(Storage.prototype);
RemovableStorage.prototype.removeAll = function () {
  this.dataStore = {};
};

const productStorage2 = new RemovableStorage();
productStorage2.put("id0001", { name: "키보드", price: 2000 });
productStorage2.removeAll();
const item2 = productStorage2.getData("id0001");

console.log(item2);
