package com.neo.byez.domain.order;

import java.util.List;

public class EtcListResponseDto {
    private List<OrderDetailDto> items;
    private int currentPage;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    // Getters and Setters
    public List<OrderDetailDto> getItems() {
        return items;
    }

    public void setItems(List<OrderDetailDto> items) {
        this.items = items;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean hasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }
}