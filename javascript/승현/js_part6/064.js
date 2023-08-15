function callRoll(students) {
  if (!Array.isArray(students)) return;

  students.forEach((student) => {
    console.log(`Are u here, ${student}`);
  });
}

const students = ["LEE", "KIM", "PARK", "TOBY"];
callRoll(students);
