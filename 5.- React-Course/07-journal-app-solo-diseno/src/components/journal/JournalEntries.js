import React from 'react'
import { JournalEntry } from './JournalEntry';

export const JournalEntries = () => {

    //nos creamos las entradas que serian las notas que estarian en el side bar
    const entries = [1,2,3,4,5];


    return (
        <div className="journal__entries"> {/** un div con este estilo */}
            
            { //como arriba tengo un arreglo de entries
            //por cada  entry  me devuelva  el componente JournalEntry
            // elparametro value es el valor de cada entry
            // y se lo damos por key al componente
                entries.map( value => (
                    <JournalEntry key={ value } />
                ))
            }

        </div>
    )
}
