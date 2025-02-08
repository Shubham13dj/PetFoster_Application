import React from 'react'

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
