import React from 'react'
import Navbar from './NavBar'
import Footer from './Footer'
import { Outlet } from 'react-router-dom'

function Layout() {
  return (
    <div className="layout">
      <Navbar />
      <main>
        {/* The Outlet will render the matched route's component */}
        <Outlet />
      </main>
      <Footer />
    </div>
  )
}

export default Layout
