import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function FetchAllProducts() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8081/product/all").then(resp => {
            setProducts(resp.data);
        })
    }, [])

    return (
        <div className='container'>
            <h2>All Products</h2>
            <table className="table">
                <thead className="thead-light">
                    <tr>
                        <th>ProductId</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map(p =>
                            <tr key={p.productId}>
                                <td>{p.productId}</td>
                                <td> {p.productName}</td>
                                <td>{p.productPrice}</td>
                                <td><Link to={`/product/get/${p.productId}`} className="btn btn-primary">View Details</Link></td>
                            </tr>
                        )
                    }

                </tbody>
            </table>

            <Link to="/" className="btn btn-info">Back To Home</Link>
        </div>
    )
}

export default FetchAllProducts;