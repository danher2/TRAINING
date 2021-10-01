import React from 'react'
import { useFetchGifs } from '../hooks/useFetchGifs'
// import { getGifs } from '../helpers/getGifs';
import { GifGridItem } from './GifGridItem';
import PropTypes from 'prop-types'



export const GifGrid = ({category}) => {

    // const [images, setimages] = useState([]);
    
    const {data:imgs,loading} = useFetchGifs(category);
    
    
   
    

   
return (
    <>
        <h3 className  ='animate__animated animate__bounce'> { category } </h3>
        {loading && <p className='animate__animated animate__flash'>Loading...</p>}
     

        <div className="card-grid">
            
            {
                imgs.map( img => (
                    <GifGridItem key={ img.id }{ ...img } />
                ))
            }
        
        </div>
    </>
)
}


GifGrid.propTypes = {
    category: PropTypes.string.isRequired


}
