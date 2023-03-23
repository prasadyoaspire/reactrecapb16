import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';
import FetchAllProducts from './components/FetchAllProducts';
import FetchProduct from './components/FetchProduct';
import AddProduct from './components/AddProduct';
import Home from './components/Home';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/product/all" element={<FetchAllProducts />} />
        <Route path="/product/get/:id" element={<FetchProduct />} />
        <Route path="/product/add" element={<AddProduct />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
