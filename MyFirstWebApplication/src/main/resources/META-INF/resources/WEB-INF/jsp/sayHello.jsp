<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sample HTML Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      line-height: 1.6;
    }
    header {
      background: #0073e6;
      color: #fff;
      padding: 10px 20px;
      text-align: center;
    }
    nav {
      margin: 20px 0;
    }
    nav a {
      margin-right: 15px;
      text-decoration: none;
      color: #0073e6;
    }
    nav a:hover {
      text-decoration: underline;
    }
    footer {
      margin-top: 20px;
      background: #333;
      color: #fff;
      padding: 10px;
      text-align: center;
    }
  </style>
</head>
<body>
  <header>
    <h1>Welcome to My Webpage</h1>
  </header>

  <nav>
    <a href="#about">About</a>
    <a href="#services">Services</a>
    <a href="#contact">Contact</a>
  </nav>

  <main>
    <section id="about">
      <h2>About Us</h2>
      <p>We are a team of passionate developers creating awesome web experiences.</p>
    </section>

    <section id="services">
      <h2>Our Services</h2>
      <ul>
        <li>Web Development</li>
        <li>App Design</li>
        <li>SEO Optimization</li>
      </ul>
    </section>

    <section id="contact">
      <h2>Contact Us</h2>
      <p>Email: <a href="mailto:contact@example.com">contact@example.com</a></p>
      <p>Phone: +1-234-567-890</p>
    </section>
  </main>

  <footer>
    <p>&copy; 2025 My Webpage. All rights reserved.</p>
  </footer>
</body>
</html>
