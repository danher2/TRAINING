//
import { createStore, combineReducers, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';

import { authReducer } from '../reducers/authReducer';
import { uiReducer } from '../reducers/uiReducer';


// configuracion
//extensio de Redux sirve para poder ver las funcionalidades de Redux en google chrome , es parte de la configuracion
const composeEnhancers = (typeof window !== 'undefined' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__) || compose;

//combine reducers que contiene los estados iniciales de mi app
const reducers = combineReducers({
    auth: authReducer, //sera manejado por authReducer
    ui: uiReducer // sirve para almacenar nuestros reducer, agregamos uiReducer
});


//el store recibe los reducer, solo recibe un reducer
export const store = createStore(
    reducers,
    composeEnhancers(
        applyMiddleware( thunk )
    )
);