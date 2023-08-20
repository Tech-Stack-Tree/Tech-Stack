const sentence = 'This will be the end of Wakanda';
console.log(sentence.substring(13));        //the end of Wakanda
console.log(sentence.substring(13, 20));    //the end
console.log(sentence.substring(0));         //This will be the end of Wakanda
console.log(sentence.substring(0, -20));    //음수를 넣으면 정상적으로 실행되지 않는다.
console.log(sentence.substring(50));        //문자열 길이를 뛰어넘는 숫자-> 빈 값
//첫번째 인자> 두번째인자 -> 두 개의 인수를 교환하여 실행한다. sentence.substring(13, 20)
console.log(sentence.substring(20,13));     //the end 