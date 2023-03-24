import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function AddProduct() {

    const [pname, setPname] = useState('');
    const [pprice, setPprice] = useState('');
    const [pdate, setPdate] = useState('');
    const [pcategory, setPcategory] = useState('');
    const [formErrors, setFormErrors] = useState({});

    const saveProduct = () => {

        let errors = {};

        if (!pname) {
            errors['pnameError'] = "Product Name is required";
        }
        if (!pprice) {
            errors['ppriceError'] = "Product Price is required";
        }
        if (pprice < 0) {
            errors['ppriceError'] = "Product Price should be positive";
        }

        setFormErrors(errors);

        const noErrors = Object.keys(errors).length === 0;

        if (noErrors) {
            const payload = {
                productName: pname,
                productPrice: pprice,
                createdDate: pdate,
                category: pcategory
            }
            axios.post("http://localhost:8081/product/save", payload).then(resp => alert("Product saved"));
        }
    }

    return (<div className="container">
        <h2>Add Product</h2>

        <div className="form-group">
            <label>Product Name</label>
            <input type="text" name="pname" value={pname} onChange={event => setPname(event.target.value)}
                className="form-control" />
                 { formErrors.pnameError && <p  style={{color: "red"}}>{formErrors.pnameError}</p>}
        </div>

        <div className="form-group">
            <label>Product Price</label>
            <input type="text" name="pprice" value={pprice} onChange={event => setPprice(event.target.value)}
                className="form-control" />
               { formErrors.ppriceError && <p  style={{color: "red"}}>{formErrors.ppriceError}</p>}
        </div>

        <div className="form-group">
            <label>Product Date</label>
            <input type="date" name="pdate" value={pdate} onChange={event => setPdate(event.target.value)}
                className="form-control" />
        </div>

        <div className="form-group">
            <label>Category</label>
            <input type="text" name="pcategory" value={pcategory} onChange={event => setPcategory(event.target.value)}
                className="form-control" />
        </div>

        <button onClick={saveProduct} className="btn btn-primary">Save</button>

        <div>
            <Link to="/" className="btn btn-info">Back To Home</Link>
        </div>

    </div>)

}

export default AddProduct;