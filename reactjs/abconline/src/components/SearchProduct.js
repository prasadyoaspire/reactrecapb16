import React, { useState } from 'react';
import axios from 'axios';
function SearchProduct() {

    const [productId, setProductId] = useState('');
    const [product, setProduct] = useState(null);
    const [message, setMessage] = useState('');
    const [formErrors, setFormErrors] = useState({});

    const handleSubmit = () => {

        let errors = {};

        if (!productId) {
            errors['productIdError'] = 'ProductId is required';
        }
        setFormErrors(errors);

        const noErrors = Object.keys(errors).length === 0

        if (noErrors) {
            axios.get("http://localhost:8081/product/" + productId).then(resp => {
                setProduct(resp.data)
            }).catch(error => {
                setProduct(null);
                setMessage(error.response.data)
            })
        }
    }

    return (
        <div>
            <div>
                <label>Product Id</label>
                <input type="text" name="productId" value={productId} onChange={e => setProductId(e.target.value)} />
                { formErrors.productIdError && <p  style={{color: "red"}}>{formErrors.productIdError}</p>}
            </div>
            <div>
                <button onClick={handleSubmit}>Search</button>
            </div>

            {
                product != null ?
                    <div>
                        <p>Id: {product.productId}</p>
                        <p>Name: {product.productName}</p>
                        <p>Price: {product.productPrice}</p>
                        <p>CreatedOn: {product.createdDate}</p>
                        <p>Category: {product.category}</p>
                    </div>
                    : <div>
                        <h3>{message}</h3>
                    </div>
            }

        </div>
    )
}

export default SearchProduct;