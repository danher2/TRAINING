import { combineReducers } from 'redux';

import { uiReducer } from './uiReducer';
import { calendarReducer } from './calendarReducer';


// aqui se guardan todos mis reducers que devuelven mis estados en un objeto que se envian al createStore
export const rootReducer = combineReducers({
    ui: uiReducer,
    calendar: calendarReducer
    // TODO: AuthReducer
})

