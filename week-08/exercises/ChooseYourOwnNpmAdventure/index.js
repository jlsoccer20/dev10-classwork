const {addDays, format} = require('date-fns');

const today = new Date();
const stringToday = format(today, 'dd.MM.yyyy');
console.log(stringToday);


const nextWeek = new Date(addDays(today, 7));
const stringNextWeek = format(nextWeek, 'dd.MM.yyyy');
console.log(stringNextWeek);

console.log("Hello World");