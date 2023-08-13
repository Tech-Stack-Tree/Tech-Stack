function callRoll(students){
    if(!Array.isArray(students)) return;

    students.forEach((student)=> {
        console.log(`Are you here, ${student}`);
    });
}

const students = ['Jun', 'Ali', 'Murry', 'Toby'];
callRoll(students);

/*
Are you here, Jun
Are you here, Ali
Are you here, Murry
Are you here, Toby
*/