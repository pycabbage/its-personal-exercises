/** @type {import('next').NextConfig} */
const nextConfig = {
  experimental: {
    serverActions: {
      allowedOrigins: [
        "localhost:5000",
        "*"
      ]
    }
  }
};

export default nextConfig;
