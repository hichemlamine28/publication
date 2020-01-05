


package com.relation.publication.Controller;

import Repository.PostRepository;
import com.relation.publication.Exception.ResourceNotFoundException;
import com.relation.publication.Model.Post;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    
    //lancer le repository en arriere plan et auto (une instance de repository)
    @Autowired
    PostRepository postRepository;

    // Get All Posts

    /**
     *
     * @return
     */
@GetMapping("/post")
public List<Post> getPosts() {
    return (List<Post>) postRepository.findAll();
}
// Create a new Post
@PostMapping("/posts")
public Post createPost(@Valid @RequestBody Post post) {
    return postRepository.save(post);
}

// Get a Single Post
@GetMapping("/posts/{id}")
public Post getPostById(@PathVariable(value = "id") Long PostId) {
    return postRepository.findById(PostId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", PostId));
}
   
// depasse en version 2 springboot
/*
// Update a Post
@PutMapping("/Post/{id}")
public Post updatePost(@PathVariable(value = "id") Long PostId,
                                        @Valid @RequestBody Post PostDetails) {

    Post Post = PostRepository.findById(PostId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", PostId));

    Post.setNom(PostDetails.getNom());
    //Post.setPrenom(PostDetails.getPrenom());
    
    Post.setMdp(PostDetails.getMdp());
    Post.setEmail(PostDetails.getEmail());
    Post.setGrade(PostDetails.getGrade());
    Post updatedPost = PostRepository.save(Post);
    return updatedPost;
}

*/
// Delete a Post
@DeleteMapping("/Posts/{id}")
public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long PostId) {
    Post post = postRepository.findById(PostId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", PostId));

    postRepository.delete(post);

    return ResponseEntity.ok().build();
}
}    

