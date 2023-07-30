function createCounterClosure() {
  let count = 0;
  return {
    increase: function () {
      count++;
    },
    getCount: function () {
      return count;
    },
  };
}

const count1 = createCounterClosure();
const count2 = createCounterClosure();

count1.increase();
count1.increase();

console.log("counter1의 값 : " + count1.getCount());
count2.increase();
console.log("counter2의 값 : " + count2.getCount());
