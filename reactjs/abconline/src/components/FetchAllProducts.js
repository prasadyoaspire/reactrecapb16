import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

function FetchAllProducts() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8081/product/all").then(resp => {
            setProducts(resp.data);
        })
    },[])

    return (
        <div>
            <h2>All Products</h2>
            {
                products.map(p =>
                    <div key={p.productId}>
                        {p.productId} {p.productName} {p.productPrice} <Link to={`/product/get/${p.productId}`}>View Details</Link>
                    </div>
                )                
            }
            <Link to="/">Back To Home</Link>
        </div>
    )
}

export default FetchAllProducts;