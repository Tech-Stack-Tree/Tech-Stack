//version.js 모듈로부터 version이름으로 내보낸 상수 값을 가져오는데, 
//이 때, as키워드를 사용하면 현재 모듈에서 다른 이름으로 사용할 수 있다.
import {version as moduleVersion} from './version.js';

const version = 'v0';
console.log(moduleVersion); //v1.0
