import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function AddProduct() {

    const [pname, setPname] = useState('');
    const [pprice, setPprice] = useState('');
    const [pdate, setPdate] = useState('');
    const [pcategory, setPcategory] = useState('');

    const saveProduct = () => {
        const payload = {
            productName: pname,
            productPrice: pprice,
            createdDate: pdate,
            category: pcategory
        }
        axios.post("http://localhost:8081/product/save", payload).then(resp => alert("Product saved"));
    }

    return (<div>
        <h2>Add Product</h2>

        <div>
            <label>Product Name</label>
            <input type="text" name="pname" value={pname} onChange={event => setPname(event.target.value)} />
        </div>
        <div>
            <label>Product Price</label>
            <input type="text" name="pprice" value={pprice} onChange={event => setPprice(event.target.value)} />
        </div>
        <div>
            <label>Product Date</label>
            <input type="date" name="pdate" value={pdate} onChange={event => setPdate(event.target.value)} />
        </div>
        <div>
            <label>Category</label>
            <input type="text" name="pcategory" value={pcategory} onChange={event => setPcategory(event.target.value)} />
        </div>

        <button onClick={saveProduct}>Save</button>

        <Link to="/">Back To Home</Link>

    </div>)

}

export default AddProduct;