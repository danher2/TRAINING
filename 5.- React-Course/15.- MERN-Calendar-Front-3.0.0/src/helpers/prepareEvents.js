import moment from 'moment'

// transformacion de fechas a objetos tipo date
export const prepareEvents = ( events = [] ) => { // recibimos los eventos para trasformalosa tipo date (start,end)

    return events.map(
        (e) => ({ // por cada evento
            ...e,  // extraigo todos los atributos
            end: moment( e.end ).toDate(), // pero covierdo e.end a fecha
            start: moment( e.start ).toDate(),// y e.start a fecha tmb
        })
    );

}