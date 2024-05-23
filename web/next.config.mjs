/** @type {import('next').NextConfig} */
const nextConfig = {
  experimental: {
    serverActions: {
      allowedOrigins: [
        "localhost:5000",
        "*.trycloudflare.com",
        "*"
      ]
    }
  }
};

export default nextConfig;
