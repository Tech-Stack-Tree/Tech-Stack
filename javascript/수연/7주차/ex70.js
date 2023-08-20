const sentence = 'Wakanda Forever!!!';
console.log(sentence.substr(8));        //Forever!!!
console.log(sentence.substr(8, 7));     //Forever
console.log(sentence.substr(0));        //Wakanda Forever!!!
console.log(sentence.substr(-10));      //Forever!!!
console.log(sentence.substr(0, -3));    //두번 째 인자 음수 -> 정상적 실행x
console.log(sentence.substr(30));       //첫번 째 인자에 문자열 길이보다 큰 수를 대입 => 빈 값 반환
console.log(sentence.substr(0, 30));    //Wakanda Forever!!! (두번째 인자는 더 커도 상관x)