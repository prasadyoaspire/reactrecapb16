import React from 'react';
import { Link } from 'react-router-dom';

function Home() {

    return (<div>
        <h1>ABC Online</h1>
        <div>
            <Link to="/product/all">View All Products</Link>
        </div>
        <div>
            <Link to="/product/add">Add New Product</Link>
        </div>
        
    </div>)
}

export default Home;