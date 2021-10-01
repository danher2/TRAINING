import { createStore, compose, applyMiddleware } from 'redux';
import thunk from 'redux-thunk'

import { rootReducer } from '../reducers/rootReducer';

//herramientas developer de redux, si existe las herramientas las va a verificar
const composeEnhancers = (typeof window !== 'undefined' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__) || compose;

export const store = createStore(
    rootReducer, // todos mis reducers (que devuelven todos los estados haciendo un estado general a la app)
    composeEnhancers(
        applyMiddleware( thunk ) // el middleware que usaremos es thunk
    )
);


