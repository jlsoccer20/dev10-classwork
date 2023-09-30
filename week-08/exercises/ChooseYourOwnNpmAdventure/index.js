const {addDays, format} = require('date-fns');

const today = format(new Date(), 'dd.MM.yyyy');
console.log(today);

const nextWeek = new Date((addDays(today, 7)));
console.log(nextWeek);

console.log("Hello World");