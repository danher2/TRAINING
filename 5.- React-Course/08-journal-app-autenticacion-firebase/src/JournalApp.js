import React from 'react';
import { Provider } from 'react-redux';

import { store } from './store/store';
import { AppRouter } from './routers/AppRouter';



export const JournalApp = () => {
    return (
        <Provider store={ store }> {/**importamos provider de react Redux igual que el context Provider y tiene la informacion del store y el store tiene toda la info de los estados de los componentes etc */}
            <AppRouter />
        </Provider>
    )
}
