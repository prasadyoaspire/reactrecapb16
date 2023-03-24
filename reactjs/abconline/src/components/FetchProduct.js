import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams,Link } from 'react-router-dom';

function FetchProduct() {

    const[product,setProduct] = useState(null);
    const {id} = useParams();

    useEffect(()=> {
        axios.get("http://localhost:8081/product/"+id).then(resp=> {
            setProduct(resp.data);
        })
    },[])

    return(<div className='container'>
        <h1>Product Details</h1>
        {
            product !== null && 
                <div>
                    <p>Id: {product.productId}</p>
                    <p>Name: {product.productName}</p>
                    <p>Price: {product.productPrice}</p>
                    <p>CreatedOn: {product.createdDate}</p>
                    <p>Category: {product.category}</p>
                </div>
        }
         <Link to="/" className="btn btn-info">Back To Home</Link>
    </div>)
}

export default FetchProduct;