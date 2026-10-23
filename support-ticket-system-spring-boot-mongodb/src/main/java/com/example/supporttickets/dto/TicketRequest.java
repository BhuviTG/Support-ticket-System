package com.example.supporttickets.dto;
import com.example.supporttickets.entity.TicketPriority;
import com.example.supporttickets.entity.TicketStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class TicketRequest {
 @NotBlank(message="Title is required") @Size(max=120,message="Title must be at most 120 characters") private String title;
 @NotBlank(message="Description is required") @Size(max=2000,message="Description must be at most 2000 characters") private String description;
 @NotBlank(message="Requester name is required") @Size(max=100,message="Requester name must be at most 100 characters") private String requesterName;
 @NotBlank(message="Requester email is required") @Email(message="Enter a valid email address") @Size(max=180,message="Email must be at most 180 characters") private String requesterEmail;
 @NotNull(message="Priority is required") private TicketPriority priority=TicketPriority.MEDIUM;
 @NotNull(message="Status is required") private TicketStatus status=TicketStatus.OPEN;
 public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
 public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
 public String getRequesterName(){return requesterName;} public void setRequesterName(String requesterName){this.requesterName=requesterName;}
 public String getRequesterEmail(){return requesterEmail;} public void setRequesterEmail(String requesterEmail){this.requesterEmail=requesterEmail;}
 public TicketPriority getPriority(){return priority;} public void setPriority(TicketPriority priority){this.priority=priority;}
 public TicketStatus getStatus(){return status;} public void setStatus(TicketStatus status){this.status=status;}
}
