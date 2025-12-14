import api from "../api/axios";
import { useEffect } from "react";

function FeedPage() {

  useEffect(() => {
    api.get("/api/posts/feed")
      .then(res => console.log(res.data))
      .catch(err => console.log(err));
  }, []);

  return <h2>Feed Page</h2>;
}

export default FeedPage;
