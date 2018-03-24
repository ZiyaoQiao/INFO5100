package WorkRequest;

import java.util.ArrayList;

public class WorkQueue {
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue(){
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList(){
        return workRequestList;
    }

    public WorkRequest createAndAddWorkRequest(WorkRequest.Type type){
        WorkRequest request = null;
        if(type == WorkRequest.Type.Complain){
            request = new ComplainWorkRequest();
            workRequestList.add(request);
        }else if(type == WorkRequest.Type.Manage){
            request = new ManageWorkRequest();
            workRequestList.add(request);
        }else if(type == WorkRequest.Type.Send){
            request = new SendWorkRequest();
            workRequestList.add(request);
        }else if(type == WorkRequest.Type.Transport){
            request = new TransportWorkRequest();
            workRequestList.add(request);
        }
        return request;
    }
    
}
