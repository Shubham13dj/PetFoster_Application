import axios from 'axios';

const uploadImage = async (img) => {
    let imageUrl = null;

    const fileData = new FormData();
    fileData.append("file", img);  // Append the image file to FormData

    try {
        // Make the API request to Pinata for uploading the image
        const responseData = await axios({
            method: 'post',
            url: "https://api.pinata.cloud/pinning/pinFileToIPFS", // Pinata upload endpoint
            headers: { 
                pinata_api_key: import.meta.env.VITE_PINATA_API_Key,
                
                pinata_secret_api_key: import.meta.env.VITE_PINATA_API_Secret,
                'Content-Type': 'multipart/form-data',
            },
            data: fileData,
        });

        // Extract the IpfsHash from the response
        const { IpfsHash } = responseData.data;

        // Construct the URL to access the image via the Pinata gateway
        imageUrl = `https://gateway.pinata.cloud/ipfs/${IpfsHash}`;
        //console.log(import.meta.env.VITE_PINATA_API_Key)
        //console.log(import.meta.env.VITE_PINATA_API_Secret)
        //console.log(imageUrl);
    } catch (err) {
        // Handle errors (optional: log more specific error info)
        console.error("Error uploading image to Pinata:", err);

        // Optionally, you can throw an error if you want to propagate the error up the call stack
        throw new Error('Image upload failed');
    }

    // Return the generated image URL after upload
    return imageUrl;
}

export default uploadImage;
