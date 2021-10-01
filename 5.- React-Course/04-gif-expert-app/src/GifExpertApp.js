import React, { useState } from 'react';
import { AddCategory } from './components/AddCategory';
import { GifGrid } from './components/GifGrid';


export const GifExpertApp = ({defaultCategories = []})=>{


    // const categories = ['One Punch ','Samurai ','Dragon Ball '];
    // const [categories, setCategories] = useState(['One Punch'])
    const [categories, setCategories] = useState(defaultCategories);

    // const handleAdd=()=>{

    //     // setCategories([...categories, 'HunterHunter']);
    //     setCategories(cats=>[...cats, 'Hunter']);
    //       }


    return(
    <>
    <h2>GifExpertApp</h2>
    <AddCategory  setCategories = {setCategories}/>
        <hr/>
            {/* Motrar la lista categorias  */}
          <ol>
              {
                categories.map(category=>(
                    <GifGrid  key = {category} category = {category}/>
                ))
            }
           </ol>
    </>

    )

}

