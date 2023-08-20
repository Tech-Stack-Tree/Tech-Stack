const sentence = 'The sun will shine on us again';
console.log(sentence.slice(13));        //shine on us again
console.log(sentence.slice(13, 24));    //shine on us
console.log(sentence.slice(0));         //The sun will shine on us again
console.log(sentence.slice(0, -23));    //The sun
console.log(sentence.slice(50));        //문자열 길이를 뛰어넘는 숫자-> 빈 값
console.log(sentence.slice(7,2));       //첫번째 인자>두번째인자 -> 정상적으로 수행x